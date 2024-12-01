Feature: Gestion des situations difficiles

  Rule: Création d'une nouvelle situation difficile

    Scenario: Création à date
      When Je déclare une nouvelle situation difficile le "2024-10-12T14:45:00Z"
      And Je déclare une nouvelle situation difficile le "2024-10-13T15:40:00Z"
      Then La liste de mes situation difficiles est
        | id  | Date creation        |
        | SD1 | 2024-10-12T14:45:00Z |
        | SD2 | 2024-10-13T15:40:00Z |

  Rule: L'étape de définition d'une situation difficile évolue

    Scenario: Création à date
      When Je déclare une nouvelle situation difficile le "2024-10-12T14:45:00Z"
      Then La situation "SD1" est à l'étape "DEFINIR_SIGNES_PHYSIOLOGIQUES"
