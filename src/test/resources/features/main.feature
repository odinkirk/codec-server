Feature: basic functionality is in place
    Scenario: Encode text
        Given a text message:
            | message |
            | Hello World |
            | spam |
            | eggs |
        When the user encodes the message
        Then the response is 200 OK
        And the encoded message is:
            | message |
            | foo |
            | bar |
            | foobar |