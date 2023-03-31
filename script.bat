javac -d . Mapping.java
javac -d . Utilitaire.java
javac -d . Url.java
javac -d . FrontServlet.java

jar cvfm framework.jar manifest.txt ETU1901/framework/Mapping.class ETU1901/framework/servlet/FrontServlet.class objet/Utilitaire.class annotation/Url.class

jar cvfm framework.war