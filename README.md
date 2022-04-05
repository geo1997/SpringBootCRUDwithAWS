# SRE - Practical Exercise

### Use Case :
Simple application which will register users for upcoming online examinations.

### Methodology:

1. Task 01:

- Implemented a CRUD application using SpringBoot.
- Port configured to run on 3000.
- REST APIs outputs JSON.
- /health , /version Routes implemented.

  Access DB : h2

   - http://{url}:3000/h2-console
   - JDBC Url :jdbc:h2:mem:examRegister
   - User Name : root

3. Task 02;

   - Used GIT and GitHub for version controlling.
   -	Configured a ci/cd pipeline using GitHub actions.
      -	On push to GitHub :
         1. Build project with maven.
         2. Dockerize the project and deploy the docker image to DockerHub.(Dockerfile)
         3. Deploy to AWS cloudformation  :  stack config for EC2 instance
            - Bootstrap the EC2 instance to :
            : Clone the code from GitHub
            : Run the docker image (docker-compose.yml)

###  Endpoints:

  **Amazone EC2 public URL: http://54.172.114.169:3000**

- **GET :  /health** : Retrieve Health Route.
- **GET : /version** : Retrieve version.
-  **GET : /users** : Retrieve all the stored users.
- **POST: /user/add** : Register a new user.
- **GET : /user/{id}** : Retrieve a specific user.
- **PUT : /updateUser** : Update an existing user.
- **DELETE : /deleteUser/{id}** : Delete a user.
