package it.ictgroup.actions.service.rs;

import io.quarkus.panache.common.Page;
import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;
import it.ictgroup.actions.model.Action;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;

@Path("/actions/starter")
@Produces("application/json")
@Consumes("application/json")
public class ActionsValidatorRs
{

   @Inject
   @Stream("actions.validate")
   Emitter<Action> validationEmitter;

   @GET
   @Path("{id}")
   @Transactional
   public boolean startValidate(@PathParam Long id) throws Exception
   {
      Action action = Action.findById(id);
      if (action == null)
      {
         throw new Exception("Cannot find id: " + id);
      }
      action.working_date = new Date();
      validationEmitter.send(action);
      return true;
   }

   @GET
   @Transactional
   public boolean startValidateAll() throws Exception
   {
      Action
               .find(
                        " select act " +
                                 " from Action act " +
                                 " where persisted_date is not null " +
                                 " and working_date is null")
               .page(Page.ofSize(5))
               .nextPage()
               .stream()
               .peek(
                        action -> {
                           ((Action) action).working_date = new Date();
                           ((Action) action).persist();
                        }
               );
      return true;
   }

}