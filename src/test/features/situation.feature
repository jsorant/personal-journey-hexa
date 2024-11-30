Feature: Gestion des situations difficiles

  Rule: Création d'une nouvelle situation difficile

    # TODO Créer plusieurs situation

    Scenario: Création à date
      When Je déclare une nouvelle situation difficile le "2024-10-12T14:45:00Z"
      Then La liste de mes situation difficiles est
        | id  | Date creation        |
        | SD1 | 2024-10-12T14:45:00Z |
