CREATE TABLE IF NOT EXISTS "users_applications" (
    "applications_users_id" integer PRIMARY KEY,
    "application_id" integer,
    "user_id" integer,
    FOREIGN KEY (application_id) REFERENCES applications(application_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    "created_at" timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);