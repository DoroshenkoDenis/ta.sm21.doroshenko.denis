Feature: Inventory page

  Background:
    Given the user goes to login page by opening Chrome
    And login with "Admin_Pro" and "Password1+"
    Then the user sees the Start page

  @UpdateObjectParamTest
  Scenario: : Update object params
    When clicks the image "Inventory"
    And select "Countries" Tab
    #   Метод создания страны пробует сначала её найти,
    #   при отсутствии,выбрасывает игнорируемое исключение (есть небольшая пауза при выполнении кода) и создаёт,
    #   если же находит, то переходит к следующему шагу
    And creates by "Create country" button "Algeria" with "Africa" continent and "Tamazight" language if not exists
    And select "Cities" Tab
    And creates by "Create city" button the "Oran" city with "609940" population and regional status "Yes"
    And the user points the mouse at "Search"
    And clicks the "Find City"
    And the user fills the fields with City test "Oran" and "609940", sets the "start with" of "Name", sets the "equal" of "Population",sets the "Yes" of "Is a regional center", and press Enter
    And open the result of search
    And select "Parameters" Tab
    And edit "Population" with data "700000"
    Then the user should see the parameter "Population" such as "700000"

  @DeleteObjectTest
  Scenario: : Delete object
    When clicks the image "Inventory"
    And select "Countries" Tab
    And find "Algeria"
    And creates by "Create city" button the "Oran" city with "1" population and regional status "Yes"
    And the user points the mouse at "Navigation"
    And clicks the "Inventory"
    And select "Countries" Tab
    And find "Algeria"
    And creates by "Create city" button the "Oran" city with "12" population and regional status "Yes"
    And the user points the mouse at "Navigation"
    And clicks the "Inventory"
    And select "Countries" Tab
    And find "Algeria"
    And creates by "Create city" button the "Oran" city with "123" population and regional status "Yes"
    When the user finds object named "Oran"
    Then the user should see the List of objects "Oran"
    And the user points the mouse at "Navigation"
    And clicks the "Inventory"
    And select "Countries" Tab
    And find "Algeria"
#   Удаляет все объекты с заданным именем, есть небольшая пауза, когда объекты больше не найдены
    And remove "Oran" if exists
    When the user finds object named "Oran"
    Then the user should see the message "No records found."













