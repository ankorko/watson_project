
### Building locally

To build the application:

1. Clone the repository  

2. Navigate to the `conversation-with-discovery` folder

3. `./gradlew build`.

4. The built WAR file (conversation-with-discovery-0.1-SNAPSHOT.war) is in the `conversation-with-discovery/build/libs/` folder.

### Running locally

1. Copy the WAR file generated above into the Liberty install directory's dropins folder. For example, `<liberty install directory>/usr/servers/<server profile>/dropins`.  
2. Navigate to the `conversation-with-discovery/src/main/resources` folder. Copy the `server.env` file.  
3. Navigate to the `<liberty install directory>/usr/servers/<server name>/` folder (where < server name > is the name of the Liberty server you wish to use). Paste the `server.env` here.  
4. In the `server.env` file, in the **"conversation"** section.  
  - Populate the "password" field.
  - Populate the "username" field.
  - Add the **WORKSPACE_ID** that you [copied earlier](#workspaceID).  
5. In the `server.env` file, in the **"discovery"** section.  
  - Populate the "password" field.
  - Populate the "username" field.
  - Add the **COLLECTION_ID** and **ENVIRONMENT_ID** that you [copied from the Discovery UI](#environmentID) 
  - (Optional) Edit the **DISCOVERY_QUERY_FIELDS** field if you set up a custom configuration . [Learn more here](custom_config/config_instructions.md).
6. Start the server using Eclipse or CLI with the command `server run <server name>` (use the name you gave your server). If you are using a Unix command line, first navigate to the `<liberty install directory>/bin/` folder and then `./server run <server name>`.
7. Liberty notifies you when the server starts and includes the port information.  
8. Open your browser of choice and go to the URL displayed in Step 6. By default, this is `http://localhost:9080/`.

