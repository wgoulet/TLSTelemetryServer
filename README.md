TLSTelemetryServer
==================

Server to gather and display metrics on TLS connections

Introduction
------------

When operating web services over TLS, it is very useful to be able to get insight as to how TLS is being used by clients that connect to a service, specifically which cipher suites are being used, TLS versions, and the properties of SSL certificates being used by the webservice.

This project implements a basic TLS telemetry server that can display metrics for TLS connections.

Architecture
------------

The TLSTelemetryServer consists of a server application that accepts TLS telemetry data via REST service call and a patched version of Tomcat8 that implements a TLS telemetry data client. The client creates a TDObject that is initialized with data extracted from a javax.net.ssl.SSLSession object that is created by Tomcat during TLS handshakes.

The TLSTelemetryServer server application is implemented as a standard Java web application with 1 REST endpoint (/tde) and a jsp page that implements the view. The Java persistance API (JPA) is used to store received TDObjects and make the objects available to the viewer, using a PostgreSQL backend.

The TLSTelemetryServer client modifications for Tomcat are applied to the SecureNioChannel class. 

The Google JSON serialization library (https://code.google.com/p/google-gson/) is used to (de)serialize TLSTelemetryData objects

Installation
------------

TLSTelemetryServer
- Deploy the TLSTelemetryServer.war file to a Tomcat7 or greater application server.
- Install PostgreSQL 9.3 or greater. Create a user account for use by the application and a database 'tlstsdb'.
- Update the persistence.xml file to point to the PostgreSQL instance created above and set the DB credentials.

TLSTelemetryServer Client Tomcat modifications
- Download the Tomcat 8 server source code from http://svn.apache.org/repos/asf/tomcat/tc8.0.x/trunk/
- Patch the ./java/org/apache/tomcat/util/net/SecureNioChannel.java with the patchfile from the wgoulet/TLSTelemetryServer/SecureNioChannel.patch
- Build the Tomcat server per standard build instructions.
- Deploy modified Tomcat server on target system and deploy any web applications as desired.
- Configure the TLS listener in the Tomcat server.xml file

Usage
-----

Establish a SSL connection to an application hosted in the modified Tomcat server. Visit http://fqdn/TLSTelemetryServer and observe the TLS connection data that was submitted.
