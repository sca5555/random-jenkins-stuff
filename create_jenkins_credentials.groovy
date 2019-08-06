import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.*

/**
 * create new credentials in a specific credential domain, designed for a shared library
 * @params: parameters_map = ["description": "<description>", 
 *                   "uid": "<uid>", 
 *                   "password": "<password>", 
 *                   "username": "username", 
 *                   "domain": "<domain_name>"]
 *
 */

def call(parameters_map){

    // domain = null = global()
    domain = new Domain(parameters_map["domain"], null, Collections.<DomainSpecification>emptyList())

    Credentials c = (Credentials) new UsernamePasswordCredentialsImpl(
            CredentialsScope.GLOBAL,
            parameters_map["uid"],
            parameters_map["descrizione"],
            parameters_map["user"],
            parameters_map["password"])

    SystemCredentialsProvider.getInstance().getStore().addCredentials(domain, c)

}

