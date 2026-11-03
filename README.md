# School Management System (Java 17)

Team: Dariya Yersainova & Gaukhar Amanbay

## Patterns (7)
| Pattern   | Class(es)                                   | Author |
|-----------|---------------------------------------------|--------|
| Factory Method | `factory/AccountFactory`               | Dariya |
| Decorator | `decorator/RoleDecorator` + 3 roles         | Dariya |
| Builder   | `builder/ReportCardBuilder`                 | Dariya |
| Observer  | `observer/GradeBook` + notifiers            | Gauhar |
| Strategy  | `strategy/GradingStrategy` + 3 algorithms   | Gauhar |
| Facade    | `facade/SchoolFacade`                       | Gauhar |
| Singleton | `singleton/SchoolDatabase`                  | shared |

## Build & run
    mkdir out
    javac -encoding UTF-8 -d out $(find src -name "*.java")
    java -cp out com.school.Main

On Windows (PowerShell):
    javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
    java -cp out com.school.Main
