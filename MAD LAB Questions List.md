# MAD-LAB Questions list:

## Lab 1: Basics of Android Mobile Application Development Tool
1. Create an Android application to show the demo of displaying text with justifying elements, changing text colors, fonts, etc.
2. Find the “Hello World” text in the XML document and modify the text.

## Lab 2: Introduction to Activity and Layouts in Android
1. Create an app that illustrates the activity lifecycle method being triggered by various actions. Understand when `onCreate()`, `onStart()`, `onResume()` events occur.
2. Create a Calculator app that performs multiplication, addition, division, and subtraction but displays the result in the format of: `Num1 operator Num2 = result`. The back button on the next activity should navigate back to the calculator activity.
3. Create the given scenario using Linear and Relative Layout concepts.
4. Create an app such that when the user clicks on a given URL typed by the user, it visits the corresponding page.

## Lab 3: Activity and Layout Continued
1. Using the given scenario, develop an application to perform the following layout operations:
   - List view
   - Grid view
   - Tab layout
   - Table layout
2. Write a program to list different sports, and when a sport is selected, display a message showing the selected sport.
3. Design a news application and implement navigation between sections like Top Stories, Sports, and Entertainment using a tab layout.

## Lab 4: Input Controls in Android
1. Develop a "Test App" that includes a layout with a Button and a ToggleButton. When each button is clicked, a custom Toast message should be displayed with different images as their content.
2. Create an app that contains a view with multiple buttons, each labeled with different Android versions. When a button is clicked, a Toast message should appear, displaying the corresponding Android version's name along with its associated icon.
3. Develop a view with a ToggleButton labeled "Current Mode" that has two states: "Wi-Fi" and "Mobile Data." Based on the state of the toggle button, an image corresponding to the selected mode should appear, and a Toast message should display the current mode. Additionally, when the user clicks the "Change Mode" button, the app should switch to the corresponding mode and update the image accordingly.
4. Create a “Food Ordering App” that lists food items with checkboxes. Once the user checks/unchecks the items and clicks on the submit button, display the items ordered along with the cost of each item and the total cost in a new activity. Once the user submits the order, they should not be allowed to change it.

## Lab 5: Input Controls - Spinners, Pickers
1. Develop an application named "Vehicle Parking Registration" where the user can register their vehicle for parking. The app should include a spinner that allows users to select the type of vehicle (e.g., car, bike, etc.) and text fields for entering the vehicle number and RC number. Upon clicking the submit button, the entered details should be displayed in a separate view, providing the user with options to either confirm the details or edit them. Once the user confirms the information, a toast message should appear showing a unique serial number to confirm the parking allotment.
2. Design and develop a "Travel Ticket Booking" app where users can book tickets by selecting the source and destination from dropdown lists (spinners) and choosing the date of travel using a date picker. Include a toggle button to specify whether they want a one-way or round-trip ticket. The app should have "Submit" and "Reset" buttons. When the "Submit" button is clicked, display the entered details on a new screen. The "Reset" button should clear all input fields.
3. Design and develop a "Movie Ticket Booking" app where users can book tickets by selecting the movie and theatre from dropdown menus (spinners), the date of the show using a date picker, and the preferred showtime using a time picker. Include a toggle button to let users choose between a standard ticket or a premium ticket. If the "premium" option is selected, ensure the "Submit" button becomes clickable only after 12:00 PM.

## Lab 6: Introduction to Menu
1. Design a home page for the "XYZ Fitness Center" using an Options Menu with the following requirements:
   - Create a simple options menu where clicking "menu options" displays "Workout Plans," "Trainers," and "Membership." 
   - "Workout Plans" should display workout programs (e.g., Weight Loss, Cardio). 
   - "Trainers" should display names and specializations of trainers with their photos.
   - "Membership" should show membership packages with pricing details.
2. The options menu should use images/icons instead of textual content. These icons should represent “Contact Us,” “About Us,” and “Homepage.” Clicking each icon should display the corresponding content.

## Lab 7: Creating Contextual and Pop-up Menus
1. Design and develop an application that displays a list of installed applications on your device. On a long press of any application, display the following options:
   - Show whether the application is a system app or user-installed.
   - Provide options to open the app, uninstall it, or view its details (e.g., version, storage usage).
   - Indicate whether the app has special permissions enabled, like location or camera access.
2. Create a View with the name “My Menu” containing an image as an icon. On clicking that icon, it should show a submenu with “Image -1” and “Image -2.” Clicking each item should display the corresponding image along with a Toast message.
3. Create a view that displays textual content about "Digital Transformation" and includes a filter option with submenus:
   - "Search Keywords" to allow searching within the content.
   - "Highlight" to highlight specific words provided by the user.
   - "Sort" to sort the content alphabetically or by relevance.

## Lab 8: Android SQLite & Shared Preferences
1. Create a "Task Manager" application with the following features:
   - A form to create and save tasks with fields like task name, due date, and priority level.
   - A list view to display saved tasks.
   - An option to edit or delete any task.
2. Write a program to add grocery items along with their cost into the database and display the total cost of all selected items. Items should be displayed through a spinner.
3. Create an application “Movie Review” that allows users to write a movie review by stating the movie name, year, and rating (1-5). Users should be able to view existing reviews displayed in a table format.
4. Use SQLite Browser to view the database, modify tables, and update the project with the modified data.
5. Create an application demonstrating Shared Preferences, where data entered in text fields is saved when the application is closed and restored upon reopening.

---
