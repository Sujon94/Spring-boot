Features followed:
● User can register himself by username and password and email address which will be save an user
● No anonymous users are allowed to use the system. They will be redirected to login
page for login.
● After login (using username/password), show a list of project generated for a particular date range (by default the current month) in tabular format. This date range can be selected/changed by the user and the result will be shown accordingly
● Allow the authenticated users to create new project which will be saved in DB. You
can use in-memory DB or any other DB of your choice. Note that you should show proper
error messages on form submission when invalid data is submitted.
The project will contain:
• name: Project name
• intro: Project introduce
• owner: Project owner (own)
• status: Project status can be pre: 1, start: 2, end: 3
• startDateTime: Project start date time, format: yyyy-MM-dd, if project status is pre, it should be null
• endDateTime: Project end date time, format: yyyy-MM-dd
• projectMembers: User can add other users as a member (optional), Any user can be the project member (maximum 5 members will allow)

Actions:
● Allow owner to edit a project entry
● Allow the user to delete a project entity.
● Create a jasper report: that will show all the projects information with status in a particular date range
● Create a REST API to get project list (GET /api/v1/projects) which will return all the projects in JSON format
● Consume this REST API, show it in html page:
https://reqres.in/api/users/2 -- Not implemented
Please consider following:
● Ask for confirmation before deleting any project entry
● Make the UI responsive and beautiful. You can use any UI framework if needed.
● It will be nice if you give form validation in client side too using Javascript