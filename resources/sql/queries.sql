-- More info: https://luminusweb.com/docs/database.html#working_with_hugsql

-- :name save-message! :! :n
-- :doc creates a new message
INSERT INTO guestbook
    (name, message, timestamp)
VALUES (:name, :message, :timestamp);

-- :name get-messages :? :*
-- :doc selects all available messages
SELECT *
FROM guestbook;