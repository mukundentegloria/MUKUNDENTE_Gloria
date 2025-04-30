FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY src ./src

RUN find src -name "*.java" > sources.txt \
 && cat sources.txt \
 && javac @sources.txt -d out \
 && echo "Compilation complete" \
 && ls -R out

CMD ["java", "-cp", "out", "allquestions.q1.MissionManagementSystem"]