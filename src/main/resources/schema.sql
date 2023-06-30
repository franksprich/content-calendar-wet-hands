CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    desc TEXT,
    status VARCHAR(20),
    content_type VARCHAR(50),
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    primary key (id)
);

INSERT INTO Content (
                     title,
                     desc,
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
