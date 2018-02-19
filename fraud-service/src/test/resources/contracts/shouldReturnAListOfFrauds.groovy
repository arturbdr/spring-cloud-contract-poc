import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpStatus

Contract.make {
    description("Should return a list of fraudsters")
    request {
        url "/fraudsters"
        method GET()
    }

    response {
        status HttpStatus.OK.value()
        body '''
            [  
               {  
                  "name":"John",
                  "age":10
               }
            ]
        '''
    }
}