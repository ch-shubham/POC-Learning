# Setup Splunk Account

- Create account on http://splunk.com
- Download splunk from settings
- install on your machine
- Run it (Default port is 8000)
- Go to setting and add Data Source
- Add the index, source, sourceType and token
- Copy the values of token, index and other required details and replace it in application.properties (Host is by default: http://localhost:8088 and not 8000)
- Hit the endpoint /health and check search logs in splunk dashboard with the query `index=your_index` and you will see your logs.
- Change the time to real time and hit the endpoint to check real time logs.