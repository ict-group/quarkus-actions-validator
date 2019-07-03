package it.ictgroup.actions.service.rs;

import it.ictgroup.actions.model.Action;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;

@Path("/actions/primo")
@Produces("application/json")
@Consumes("application/json")
public class ActionsRs
{

   @POST
   @Transactional
   public Action persist(Action primo)
   {
      primo.persisted_date = new Date();
      primo.persist();
      return primo;
   }

}