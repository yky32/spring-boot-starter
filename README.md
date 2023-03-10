# spring-boot-template

Spring boot microservice template.

## Tech stack
- Java 11 JDK
- Git
- Docker / Docker-compose
- Maven
- Junit5 / Mockito
- MySQL 8 / Postgres

## Pre-requisite

- [ ] configure your `Users/${user}/.m2/settings.xml` ![img.png](m2-path.png)
- [ ] put down your `GitLab` `accessToken` ![img.png](setting-xml.png)
  - [GitLab Generating Token Link](https://deloitte.team/help/user/profile/personal_access_tokens.md#create-a-personal-access-token)
- [ ] Docker running mysql image
- [ ] go and see `docker-compose` in `cd ~/.setup`

## Testing 

- [ ] [swagger link](http://localhost:9000/swagger-ui.html)


## Design Principle
### Directories structure
- config
- endpoint
- entity
  - dto
  - po
- exception
- repository
- service
- usecase `optional`
