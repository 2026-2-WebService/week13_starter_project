# Week 13 — Spring Security Lab A (학생용 Starter)

**Course:** Web Service Development · 150-minute class  
**Stack:** Java 17, Spring Boot 3.5.16, Gradle 8.x, Thymeleaf.

## Launch

1. Open this folder as a Gradle project in IntelliJ, or run `gradle bootRun` with Gradle 8.x installed.
2. Java 17+ is required. If Gradle is not installed, IntelliJ's Gradle integration can use a local Gradle distribution.
3. Open http://localhost:8080/.

**Local-only default account:** `user / 1234` (configured in `application.properties`).

## Student learning tasks
1. Open `config/SecurityConfig.java` and complete TODO A-1 through A-3.
2. Compare `/`, `/mypage`, `/admin` before and after editing.
3. Why does the default `user` receive HTTP 403 for `/admin`?

## Verification
- `/` → 200
- anonymous `/mypage` → 302 to login
- default user `/mypage` → 200
- default user `/admin` → 403

## Notes
- CSRF protection remains **enabled**. Thymeleaf `th:action` POST forms automatically contain the CSRF input.
- Do not push real DB passwords or Google OAuth secrets to GitHub.
- The local demo passwords are intentionally simple. Never deploy these settings publicly.
- No JWT issuance is implemented: JWT is covered conceptually in the lecture.
- The instructor's Google OAuth demo is separate and optional.
- Reference: https://docs.spring.io/spring-security/reference/6.5/servlet/authentication/passwords/form.html
