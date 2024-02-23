package Database;

import org.neo4j.driver.AuthToken;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;

public class Connect {
	public static Session connect() {
		String url = "neo4j://localhost:7687";
		String user = "neo4j";
		String pass = "16042003";
		
		Driver driver = GraphDatabase.driver(url, AuthTokens.basic(user, pass));
		Session session = driver.session(SessionConfig.forDatabase("coursedb"));
		return session;
	}
}
