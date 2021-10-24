Feature: Start page

  Background:
    Given the user goes to login page by opening Chrome
    And login with "Admin_Pro" and "Password1+"
    Then the user sees the Start page

  @NavigationListTest
  Scenario Outline: : Check the "<Link>"  in the Navigation List
    Given the user is logged in as "Admin_Pro"
    When the user points the mouse at "Navigation"
    And clicks the "<Link>"
    Then the user should see the current page "<Page>" and "<Page dispatcher>"
    Examples:
      | Link                  | Page                 | Page dispatcher               |
      | Inventory             | Inventory            | Top > Inventory >             |
#      Infrastructure Orders - disabled Тест упадёт
      | Infrastructure Orders | Inventory Orders     | Top > Infrastructure Orders > |
      | Tools                 | Administrative tools | Top > Administrative tools >  |

  @ObjectsCreationsTest
  Scenario: : Create Tree of Objects with test data
    Given the user is logged in as "Admin_Pro"
    When the user points the mouse at "Navigation"
    And clicks the "Inventory"
    And select "Countries" Tab
#   Метод удаления при отсутствии элемента выбрасывает игнорируемое исключение, есть небольшая пауза при выполнении кода
    And remove "Honduras" if exists
    And creates by "Create country" button "Honduras" with "North America" continent and "Spanish" language
    And select "Cities" Tab
    And creates by "Create city" button the "Tegucigalpa" city with "1682725" population and regional status "Yes"
    And select "Buildings" Tab
    And creates by "Create building" button the "Torre InterPlaza" with street "Boulevard Juan Pablo", build number "2", Square "10000" and Connection status "Lit"
    And select "Floors" Tab
    And creates by "Create floor" button the "1" floor with "1000" square
    And select "Rooms" Tab
    And creates by "Create room" button the "server-room" room with "100" square
    And select "Racks" Tab
    And creates by "Create rack" button the "IP65-12U__Rack" rack with width: "930", length: "600", height: "1950", "In Service" physical status
    And select "Devices" Tab
    And creates by "Create device" button the "HP Proliant DL380 Gen9" device with "8A:15:CB:C6:56:6F" MAC Address, "128" Gb RAM, "2x3.2 GHz 8-Core Xeon E5-2667v3" CPU, "221.82.218.131" IP Address, "In Service" physical status, width: "679", length: "445", height: "87", Located in "Honduras" "Tegucigalpa" "Torre InterPlaza", Network Element:  "1" floor, "server-room" room, "IP65-12U__Rack" network element
    Then the user should see the current page "HP Proliant DL380 Gen9" and "Top > Inventory > Honduras > Tegucigalpa > Torre InterPlaza > Floor#1 > server-room > IP65-12U__Rack > HP Proliant DL380 Gen9 >"

  @ObjectsSearchTest
  Scenario Outline: : Search Objects with test data
    When the user click Search... field and press Enter
    Then the user should see the current page "Generic Search" and "Top > Generic Search"
    When fill field with search "<Data>", select "<search type>" and press Enter
    Then the user should see result "<Object>"
    Examples:
      | Data           | search type | Object         |
      | IP65-12U__Rack | equal       | IP65-12U__Rack |
      | 12U            | contains    | IP65-12U__Rack |
      | IP65           | start with  | IP65-12U__Rack |
      | Rack           | end with    | IP65-12U__Rack |


