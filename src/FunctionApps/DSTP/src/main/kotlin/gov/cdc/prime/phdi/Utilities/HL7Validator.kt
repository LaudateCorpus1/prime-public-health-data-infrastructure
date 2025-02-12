package gov.cdc.prime.phdi.Utilities

import ca.uhn.hl7v2.DefaultHapiContext
import ca.uhn.hl7v2.HL7Exception
import ca.uhn.hl7v2.HapiContext
import ca.uhn.hl7v2.parser.Parser
import ca.uhn.hl7v2.validation.ValidationContext
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory
import ca.uhn.hl7v2.Version
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationBuilder

public class HL7Validator() {
    public fun isValidHL7Message(message: String): Boolean {
        val context = DefaultHapiContext()
        // We will likely replace this with a more custom validation class in the future
        context.setValidationContext(ValidationContextFactory.defaultValidation() as ValidationContext);
        val parser = context.getPipeParser()

        /*
            For now, we don't track or log why a message fails
            to get parsed by HL7. We simply return true if HAPI
            is able to successfully parse the message, and false
            if it can't, based on the validation context that's
            set above.
        */
        try {
            parser.parse(message)
            return true
        } catch (e: HL7Exception) {
            return false
        }
    }   
}
