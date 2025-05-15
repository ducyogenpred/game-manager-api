INSERT INTO users (first_name, middle_name, last_name, display_name, email, phone_number, password, birth_date, description, created_at, updated_at)
VALUES
    ('John', 'A', 'Doe', 'john_doe', 'john@example.com', '1234567890', 'password123', '1990-01-01', 'Gamer and developer', NOW(), NOW()),
    ('Jane', 'B', 'Smith', 'jane_smith', 'jane@example.com', '0987654321', 'password456', '1995-05-15', 'Loves RPGs', NOW(), NOW()),
    ('Michael', 'C', 'Johnson', 'mike_j', 'michael@example.com', '5551234567', 'securepass', '1988-07-22', 'Streamer and content creator', NOW(), NOW()),
    ('Sarah', 'L', 'Williams', 'sarah_w', 'sarah@example.com', '4449876543', 'sarahpass', '1992-11-30', 'Indie game enthusiast', NOW(), NOW()),
    ('David', 'K', 'Brown', 'dave_brown', 'david@example.com', '7775551234', 'davidpass', '1985-03-18', 'Competitive esports player', NOW(), NOW());

INSERT INTO publishers (name, description, email, review_count, rating_average, created_at, updated_at)
VALUES
    ('Electronic Arts', 'One of the largest video game publishers in the world, known for franchises like FIFA, Madden NFL, and The Sims.', 'contact@ea.com', 1250, 4.2, NOW(), NOW()),
    ('Ubisoft', 'French video game company known for Assassin''s Creed, Far Cry, and Rainbow Six series.', 'support@ubisoft.com', 980, 4.0, NOW(), NOW()),
    ('Nintendo', 'Japanese multinational consumer electronics and video game company, creator of Mario, Zelda, and Pokémon.', 'info@nintendo.com', 3500, 4.8, NOW(), NOW()),
    ('Activision Blizzard', 'American video game holding company behind Call of Duty, World of Warcraft, and Overwatch.', 'inquiries@activision.com', 2100, 3.9, NOW(), NOW()),
    ('Square Enix', 'Japanese video game developer and publisher famous for Final Fantasy, Dragon Quest, and Kingdom Hearts series.', 'contact@square-enix.com', 870, 4.3, NOW(), NOW());