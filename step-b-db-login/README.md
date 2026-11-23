# Week 13 — Spring Security Lab B (학생용 Starter)

**Course:** Web Service Development · 150-minute class  
**Stack:** Java 17, Spring Boot 3.5.16, Gradle 8.x, Thymeleaf, Spring Data JPA, MariaDB.

## Launch

1. Open this folder as a Gradle project in IntelliJ, or run `gradle bootRun` with Gradle 8.x installed.
2. Java 17+ is required. If Gradle is not installed, IntelliJ's Gradle integration can use a local Gradle distribution.
3. Open http://localhost:8080/.

### External MariaDB setup (no Docker)

Use the **external MariaDB server account already assigned for this course**. You do not need Docker or a local MariaDB installation.

1. Check the external DB host, port, database/schema name, assigned username, and password provided for the course.
2. In IntelliJ, open **Run > Edit Configurations > Environment variables** for `Week13Application` and set:
   - `DB_URL=jdbc:mariadb://<EXTERNAL_DB_HOST>:3306/<YOUR_DATABASE>`
   - `DB_USERNAME=<YOUR_ASSIGNED_USERNAME>`
   - `DB_PASSWORD=<YOUR_ASSIGNED_PASSWORD>`
3. Run the Spring Boot application and confirm the connection.
4. Use only your **assigned database/schema**; never create tables in another student's schema.
5. `spring.jpa.hibernate.ddl-auto=update` is for this lab only. If your account lacks table-creation privileges, ask your instructor to prepare the `member` table and use `validate` instead.
6. If the connection fails, check access to the DB server/network, JDBC URL, username/password, and user permissions.

The project contains **no actual DB credentials**. Never commit real passwords or put them in README, source files, or screenshots.

**Do not run Step A and Step B simultaneously on port 8080.**

## Student learning tasks
1. Inspect Member → MemberRepository → MemberService → CustomUserDetailsService.
2. Complete the missing password hash and UserDetails conversion TODOs.
3. Register an account; check the stored BCrypt hash in MariaDB.
4. Log in as USER, try `/mypage` and `/admin`.
5. Explain `hasRole("ADMIN")` vs `authenticated()`.


## Verification
- `/register` GET → 200; POST with valid CSRF creates USER account
- DB password value starts with a bcrypt hash prefix (typically `$2a$` or `$2b$`)
- USER `/mypage` → 200; USER `/admin` → 403
- ADMIN `/admin` → 200
- POST `/logout` with CSRF logs out


## Notes
- CSRF protection remains **enabled**. Thymeleaf `th:action` POST forms automatically contain the CSRF input.
- Do not push real DB passwords or Google OAuth secrets to GitHub.
- Step A uses a classroom-only password. Never deploy that setting publicly.
- No JWT issuance is implemented: JWT is covered conceptually in the lecture.
- The instructor's Google OAuth demo is separate and optional.
- Reference: https://docs.spring.io/spring-security/reference/6.5/servlet/authentication/passwords/form.html
