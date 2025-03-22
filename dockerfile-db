FROM  postgres:15

ENV POSTGRES_USERNAME=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=ecommerce_db

EXPOSE 5432

COPY ./src/main/resources/sql-scripts/db_schema.sql /docker-entrypoint-initdb.d/