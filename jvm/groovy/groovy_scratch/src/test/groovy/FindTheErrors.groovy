import org.junit.jupiter.api.Test

class FindTheErrors
{
    @Test
    void name()
    {
        String[][] validCombos = [
                ["a", "b", "c"],
                ["d", "e", "f"]
        ]

        String[] input = ["bb", "v", "w"]

        if (input !in validCombos) {
            throw new Exception("!")
        }
    }

    @Test
    void anotherTest()
    {
        Map values = [
                L: ["f", "g", "r"]
        ]

        String VALID = "VALID"
        String ARREARS_N_INVALID = "ARREARS_N_INVALID"

        Map allCombos = [
                L: [
                        I: [I:[VALID: [""]], X:[ARREARS_N_INVALID:
                                                        [
                                                                validationMessage: ValidationMessage.ARREARS_L_INVALID,
                                                                singletonList: ["client.1.member"]
                                                        ]
                        ]
                        ],
                        Y: [I:"member.something"]
                ],
                B: [
                        J: "X"
                ]
        ]

        allCombos.arreasInd.satus.normalPay //[
                                            //        validationMessage: ValidationMessage.ARREARS_L_INVALID,
                                            //        singletonList: ["client.1.member"]
                                            //]

        def (journalRef, indicator, status)  = ["vvv", "ddd", "Y"]

        assert status == allCombos?.journalRef?.indicator
    }
}
