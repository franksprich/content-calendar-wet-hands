CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20),
    content_type VARCHAR(50),
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    primary key (id)
);

INSERT INTO Content (
                     title,
                     description,
                     status,
                     content_type,
                     date_created
                     )
VALUES (
        'My First Blog Post',
        'My first blog post xxx',
        'IDEA',
        'ARTICLE',
        CURRENT_TIMESTAMP()
        )
