import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should send a Fraud Message"
    label "triggerFraud"
    input {
        triggeredBy("triggerMessage()")
    }
    outputMessage {
        sentTo "fraud"
        body '''
                {  
                  "name":"John",
                  "age":10
                }
        '''
    }
}