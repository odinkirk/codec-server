Feature: basic functionality is in place
    Scenario: Encode text
        Given a text message
            | codec     | message |
            | caesar+3  | Hello World |
            | caesar+3  | spam |
            | caesar+3  | eggs |
        When the user encodes the message
        Then the response is 200 OK
        And the encoded message is:
            | codec     | message       | encoded |
            | caesar+3  | Hello World   | Khoor Zruog |
            | caesar+3  | spam          | vdph |
            | caesar+3  | eggs          | jhwv |