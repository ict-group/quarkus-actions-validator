package it.ictgroup.actions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "actions")
public class Action extends PanacheEntity
{
   public String product_id;

   public String user_id;

   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
   public Date persisted_date;

   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
   public Date working_date;

   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
   public Date validate_date;

   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
   public Date end_date;

   public String action;

   @Override public String toString()
   {
      return "Primo{" +
               "product_id='" + product_id + '\'' +
               ", user_id='" + user_id + '\'' +
               ", persisted_date=" + persisted_date +
               ", action='" + action + '\'' +
               '}';
   }
}
