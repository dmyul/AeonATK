package edu.yale.mssa

class SecurityService {

    static transactional = true

    def checkSecret(String secretIn) {   
        def hash = "5f4dcc3b5aa765d61d8327deb882cf99"
        def challenge = secretIn.encodeAsMD5()
        
        if(hash.equals(challenge)){
            return true;
        }
        else return false;SecurityService
    }
}
