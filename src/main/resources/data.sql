INSERT INTO users (first_name, middle_name, last_name, display_name, email, phone_number, password, birth_date, description, created_at, updated_at)
VALUES
    ('John', 'A', 'Doe', 'john_doe', 'john@example.com', '1234567890', 'password123', '1990-01-01', 'Gamer and developer', NOW(), NOW()),
    ('Jane', 'B', 'Smith', 'jane_smith', 'jane@example.com', '0987654321', 'password456', '1995-05-15', 'Loves RPGs', NOW(), NOW()),
    ('Michael', 'C', 'Johnson', 'mike_j', 'michael@example.com', '5551234567', 'securepass', '1988-07-22', 'Streamer and content creator', NOW(), NOW()),
    ('Sarah', 'L', 'Williams', 'sarah_w', 'sarah@example.com', '4449876543', 'sarahpass', '1992-11-30', 'Indie game enthusiast', NOW(), NOW()),
    ('David', 'K', 'Brown', 'dave_brown', 'david@example.com', '7775551234', 'davidpass', '1985-03-18', 'Competitive esports player', NOW(), NOW());

INSERT INTO publishers (name, description, email, created_at, updated_at)
VALUES
    ('Electronic Arts', 'One of the largest video game publishers in the world, known for franchises like FIFA, Madden NFL, and The Sims.', 'contact@ea.com', NOW(), NOW()),
    ('Ubisoft', 'French video game company known for Assassin''s Creed, Far Cry, and Rainbow Six series.', 'support@ubisoft.com', NOW(), NOW()),
    ('Nintendo', 'Japanese multinational consumer electronics and video game company, creator of Mario, Zelda, and Pokémon.', 'info@nintendo.com', NOW(), NOW()),
    ('Activision Blizzard', 'American video game holding company behind Call of Duty, World of Warcraft, and Overwatch.', 'inquiries@activision.com', NOW(), NOW()),
    ('Square Enix', 'Japanese video game developer and publisher famous for Final Fantasy, Dragon Quest, and Kingdom Hearts series.', 'contact@square-enix.com', NOW(), NOW());

INSERT INTO developers (name, description, email, created_at, updated_at)
VALUES
    ('Naughty Dog', 'American first-party video game developer owned by Sony Interactive Entertainment, known for Uncharted and The Last of Us series.', 'contact@naughtydog.com', NOW(), NOW()),
    ('CD Projekt Red', 'Polish video game developer best known for The Witcher series and Cyberpunk 2077.', 'info@cdprojektred.com', NOW(), NOW()),
    ('FromSoftware', 'Japanese developer famous for challenging action RPGs like Dark Souls, Bloodborne, and Elden Ring.', 'support@fromsoftware.jp', NOW(), NOW()),
    ('Insomniac Games', 'American developer known for Ratchet & Clank, Spyro, and Marvel''s Spider-Man series.', 'contact@insomniac.games', NOW(), NOW()),
    ('Rockstar North', 'Scottish developer best known for the Grand Theft Auto series and Red Dead Redemption.', 'inquiries@rockstarnorth.com', NOW(), NOW());

INSERT INTO genres (name, description, created_at, updated_at)
VALUES
    ('Action', 'Fast-paced games focused on physical challenges, hand-eye coordination, and reaction time. Includes shooters, fighting games, and platformers.', NOW(), NOW()),
    ('Adventure', 'Story-driven games emphasizing exploration, puzzle-solving, and narrative progression. Often features rich worlds and character development.', NOW(), NOW()),
    ('Role-Playing (RPG)', 'Games where players assume the roles of characters in a fictional setting, with character progression and complex storylines.', NOW(), NOW()),
    ('Strategy', 'Games that require careful planning and resource management to achieve victory, including turn-based and real-time variants.', NOW(), NOW()),
    ('Simulation', 'Games that simulate real or fictional reality, including life simulations, vehicle simulations, and city builders.', NOW(), NOW()),
    ('Sports', 'Games that simulate traditional physical sports, including team sports, extreme sports, and competitive athletics.', NOW(), NOW()),
    ('Puzzle', 'Games focused on solving puzzles, testing logic, pattern recognition, and problem-solving skills.', NOW(), NOW()),
    ('Horror', 'Games designed to scare and unsettle players, often featuring dark themes, survival elements, and psychological tension.', NOW(), NOW()),
    ('Open World', 'Games that allow players to freely explore virtual worlds with minimal restrictions and nonlinear gameplay.', NOW(), NOW()),
    ('MMO', 'Massively multiplayer online games where large numbers of players interact in persistent virtual worlds.', NOW(), NOW());

INSERT INTO games (title, description, release_date, publisher_id, developer_id, created_at, updated_at)
VALUES
    ('The Witcher 3: Wild Hunt', 'Open-world RPG following Geralt of Rivia as he searches for his adopted daughter in a war-torn fantasy world.', '2015-05-19', 2, 2, NOW(), NOW()),
    ('The Last of Us Part II', 'Action-adventure survival horror game set in a post-apocalyptic world, following Ellie''s journey of revenge.', '2020-06-19', 3, 1, NOW(), NOW()),
    ('Elden Ring', 'Open-world action RPG featuring challenging combat and a dark fantasy world created by Hidetaka Miyazaki and George R.R. Martin.', '2022-02-25', 5, 3, NOW(), NOW()),
    ('Grand Theft Auto V', 'Open-world action-adventure game set in the fictional city of Los Santos, following three criminals and their heists.', '2013-09-17', 4, 5, NOW(), NOW()),
    ('Cyberpunk 2077', 'Open-world action RPG set in Night City, a megalopolis obsessed with power, glamour and body modification.', '2020-12-10', 2, 2, NOW(), NOW()),
    ('Marvel''s Spider-Man', 'Action-adventure game featuring Peter Parker as Spider-Man protecting New York City from various threats.', '2018-09-07', 3, 4, NOW(), NOW()),
    ('Red Dead Redemption 2', 'Western-themed action-adventure game set in 1899 America following outlaw Arthur Morgan.', '2018-10-26', 4, 5, NOW(), NOW()),
    ('Dark Souls III', 'Action RPG known for its challenging gameplay and dark fantasy setting, the final installment in the Dark Souls series.', '2016-03-24', 5, 3, NOW(), NOW()),
    ('Uncharted 4: A Thief''s End', 'Action-adventure game following Nathan Drake''s final treasure hunting adventure.', '2016-05-10', 3, 1, NOW(), NOW()),
    ('Assassin''s Creed Valhalla', 'Action RPG set during the Viking invasion of Britain, following Eivor''s quest for glory.', '2020-11-10', 2, 4, NOW(), NOW());

INSERT INTO users (first_name, middle_name, last_name, display_name, email, phone_number, password, birth_date, description, created_at, updated_at)
VALUES
    ('Alex', 'James', 'Johnson', 'alex_gamer', 'alex.j@example.com', '5551234567', '$2a$10$xJwL5v5zJzU6Z7b8XQz3O.9Xq1W2s3D4F5G6H7J8K9L0M1N2O3P4Q5', '1990-05-15', 'Hardcore FPS player and game collector', NOW(), NOW()),
    ('Sarah', NULL, 'Williams', 'sarah_will', 'sarah.w@example.com', '5552345678', '$2a$10$yKvL6w4yLzU7X8b9YR0P1.Q2r3S4t5U6V7W8X9Y0Z1A2B3C4D5E6F', '1995-08-22', 'RPG enthusiast and indie game supporter', NOW(), NOW()),
    ('Michael', 'Robert', 'Brown', 'mike_brown', 'michael.b@example.com', '5553456789', '$2a$10$zLwM7x5zM8V9N0b1CT2D3.E4f5G6h7J8K9L0M1N2O3P4Q5R6S7T8U', '1988-11-30', 'Competitive esports player specializing in MOBAs', NOW(), NOW()),
    ('Emily', 'Grace', 'Davis', 'emily_d', 'emily.d@example.com', '5554567890', '$2a$10$aNxO9p6qQr7S8t9Uv0W1X2.Y3Z4A5B6C7D8E9F0G1H2I3J4K5L6M7N', '1993-03-10', 'Casual mobile gamer and puzzle game lover', NOW(), NOW()),
    ('David', NULL, 'Miller', 'dave_mill', 'david.m@example.com', '5555678901', '$2a$10$bOyP0r7sT8U9V0w1X2Y3Z4.A5B6C7D8E9F0G1H2I3J4K5L6M7N8O9P', '1985-07-18', 'Retro game collector and speedrunner', NOW(), NOW()),
    ('Jessica', 'Anne', 'Wilson', 'jess_w', 'jessica.w@example.com', '5556789012', '$2a$10$cPzQ1r2sT3U4V5W6X7Y8Z9.A0B1C2D3E4F5G6H7I8J9K0L1M2N3O4P', '1992-09-25', 'Streamer focusing on story-driven games', NOW(), NOW()),
    ('Daniel', 'Thomas', 'Taylor', 'dan_t', 'daniel.t@example.com', '5557890123', '$2a$10$dQwR2sT4U5V6W7X8Y9Z0A1.B2C3D4E5F6G7H8I9J0K1L2M3N4O5P6Q', '1998-01-05', 'VR gaming enthusiast and tech reviewer', NOW(), NOW()),
    ('Olivia', NULL, 'Anderson', 'olivia_a', 'olivia.a@example.com', '5558901234', '$2a$10$eRxS3t5U6V7W8X9Y0Z1A2.B3C4D5E6F7G8H9I0J1K2L3M4N5O6P7Q8', '1994-12-15', 'Simulation and strategy game specialist', NOW(), NOW()),
    ('James', 'Patrick', 'Martinez', 'james_m', 'james.m@example.com', '5559012345', '$2a$10$fSyT4u6V7W8X9Y0Z1A2B3.C4D5E6F7G8H9I0J1K2L3M4N5O6P7Q8R9', '1987-04-20', 'Game developer and indie game advocate', NOW(), NOW()),
    ('Sophia', 'Marie', 'Garcia', 'sophia_g', 'sophia.g@example.com', '5550123456', '$2a$10$gTzU5v7W8X9Y0Z1A2B3C4.D5E6F7G8H9I0J1K2L3M4N5O6P7Q8R9S0', '1996-06-08', 'Casual gamer who enjoys co-op experiences', NOW(), NOW());