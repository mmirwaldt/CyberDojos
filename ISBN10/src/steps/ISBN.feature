
Feature: ISBN Validator for ISBN-10 and ISBN-13

Scenario Outline: example cases for both formats
    Given we have an ISBN validator
    When we give it <isbn_str>
    Then it is <valid_or_not>

    Examples: ISBN-10 digits only length check
    | isbn_str       | valid_or_not |
    | 0471958697     | valid        |
    | 123            | invalid      |

    Examples: ISBN-10 checksum confirmation
    | isbn_str       | valid_or_not |
    | 0471958692     | invalid      |
    | 0-8044-2957-X  | valid        |
    | 0-9752298-0-X  | valid        |
    | 007462542X     | valid        |
    | 347195869X     | valid        |

    Examples: ISBN-10 digits and spaces
    | isbn_str       | valid_or_not |
    | 0 471 60 695 2 | valid        |
    | 0-471-60-695-2 | valid        |
    | 0-321-14653-0  | valid        |
