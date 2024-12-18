import org.junit.jupiter.api.Test

class FailedUiTests
{
    static String failedMethods = """\
uk.co.heywood.business.javabatch.isp.datatransfer.contacts.IspContactsDataTransferIT\$Configured.shouldNotExtractData_whenValidRequest_withNoMatchingSchemes()
uk.co.heywood.business.javabatch.isp.datatransfer.contacts.IspContactsDataTransferIT\$Configured.shouldExtractData_whenValidRequest_withMatchingScheme()
uk.co.heywood.business.workflow.autoexecutetask.AutoExecuteTaskIT\$AggregateNDTAutoExecutableTask.shouldFailTask_whenAggregationThrowsException()
uk.co.heywood.business.workflow.autoexecutetask.AutoExecuteTaskIT\$AggregateNDTAutoExecutableTask.shouldFailTask_whenAggregationReturnsError()
uk.co.heywood.business.workflow.autoexecutetask.AutoExecuteTaskIT\$AggregateNDTAutoExecutableTask.shouldFailTask_whenNoTargetEmployment()
uk.co.heywood.business.workflow.autoexecutetask.AutoExecuteTaskIT\$AggregateNDTAutoExecutableTask.shouldFailTask_whenMoreThanOneTargetEmployment()
uk.co.heywood.business.workflow.autoexecutetask.AutoExecuteTaskIT\$AggregateNDTAutoExecutableTask.shouldCompleteTask_whenAggregationIsSuccessfulWithWarnings()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testWhenFetchingAllEsProperties_thenAnyInvalidEsPropertiesAreRemovedFromDb()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testCanRemoveProperty()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testCanSetVeryLongPropertyValue()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testCanSetPropertyToBlank()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testCanSetNewPropertyForDifferentTypes()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testCanChangeExistingProperty()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testWhenFetchingAllStandardProperties_thenAnyInvalidStandardPropertiesAreRemovedFromDb()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testAddedPropertyIsIncludedInSupportServletHTML()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testWhenThereAreNoInvalidProperties_thenNoPropertiesAreRemovedFromDb()
uk.co.heywood.support.serviceproperties.ServicePropertiesIT.testWhenFetchingAllMssProperties_thenAnyInvalidMssPropertiesAreRemovedFromDb()
uk.co.heywood.business.workflow.autoexecutetask.AutoExecuteTaskIT\$AggregateNDTAutoExecutableTask.shouldCompleteTask_whenAggregationIsSuccessful()\
""".trim()

    @Test
    void "extract failed tests for gradle run"() {

        String branch = "raya"
//        branch = "raya"
        String domain = ".altdev.ahnet.co.uk"
//        domain = ""
        String target_host = ["10.7.56.145","10.7.56.124","10.7.56.148","10.7.56.147","10.7.56.125"].join(",")
        target_host = "10.7.56.207,10.7.56.206,10.7.57.249,10.7.57.213,10.7.57.239"
//        target_host = ["al-l-1103", "alt-smoulem"].collect{it + domain}.join(",")
//        target_host = ["alt-smoulem"].collect{it + domain}.join(",")

        String commandParams = failedMethods.split("\n").collect {
            String res = it.substring(0, it.lastIndexOf("("))
        }.join(" --tests ")

        String command = """\
./gradlew :AltairCucumberFramework:clean :AltairCucumberFramework:runUiTests \
--refresh-dependencies \
-DBranch=${branch} \
-DHosts=${target_host} \
-DCobolFree=false \
-Dbrowser=Chrome \
-DuseSeleniumGrid=true \
-DmailHost=cx-d-kub-t-11.altdev.ahnet.co.uk \
-DmailPort=30725 \
--tests \
"""

        println(command + commandParams)
    }

    @Test
    void "regex to get class name of failure methods"() {
        def result = failedMethods.split("\n").collect {getClassName(it)
        }.join(",")

        println(result)
    }

    private static String getClassName(String string)
    {
        def (_, className) = (string =~ /.*\.(.+)\..+\(\)$/)[0]
        className
    }

    @Test
    void "regex to get class name dot method name"() {
        def result = failedMethods.split("\n").collect {getClassDotMethodName(it)
        }.join(",")

        println(result)
    }

    private static String getClassDotMethodName(String string)
    {
        def (_, classDotMethod) = (string =~ /.*\.(.+\..+)\(\)$/)[0]
        classDotMethod
    }

    @Test
    void "get class name of failure methods"() {
        def result = failedMethods.split("\n").collect {
            String res = it.substring(0, it.lastIndexOf(".")) // remove method name at the end
            res.substring(res.lastIndexOf(".")+1) // get the simple class name
        }.join(",")

        println(result)
    }

    @Test
    void "get class dot method name of failure methods"() {
        def result = failedMethods.split("\n").collect {
            String res = it.substring(0, it.lastIndexOf("(")) // remove method name at the end
            String methodName = res.substring(res.lastIndexOf(".")+1) // get the simple class name
            String fullyQualifiedClassName = res.substring(0, res.lastIndexOf('.'))
            String simpleClassName = fullyQualifiedClassName.substring(fullyQualifiedClassName.lastIndexOf(".")+1)
            "${simpleClassName}.$methodName"
        }.join(",")

        println(result)
    }
}
