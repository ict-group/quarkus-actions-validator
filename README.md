# quarkus-actions-validator
quarkus project to validate json objects using kafka queues


- step 1
We will create a pom maven project with some microservice modules:
 - api (shared library)
 - users (rest api to create an user with uuid, name, surname, email, creation_date)
 - products (rest api to create an product with uuid, name, category, creation_date)
 - actions (rest api to create a join object between user, product, with action "like, dislike")
 
