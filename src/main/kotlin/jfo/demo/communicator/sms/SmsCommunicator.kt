package jfo.demo.communicator.sms

import arrow.core.Either
import arrow.core.right
import jfo.demo.communicator.CommunicatorError
import jfo.demo.communicator.CommunicatorSuccess
import jfo.demo.communicator.Communicator
import jfo.demo.communicator.DataInfo

data class SmsInfo(
    val phone: String,
    val msg: String
) : DataInfo()

class SmsCommunicator(private val sms: SmsInfo) : Communicator() {
    override fun execute() : Either<CommunicatorError, CommunicatorSuccess> {
        println("Sms communicator sending to ${sms.phone} - ${sms.msg}")
        return CommunicatorSuccess.right()
    }
}

//data class SmsCommunicatorData(
//    val sms: String,
//    val data: CommunicatorData
//)

//class SmsSender{
//    fun send(smsCommunicatorData: SmsCommunicatorData){
//        println("Sending SMS to ${smsCommunicatorData.sms} with info ${smsCommunicatorData.data.info}")
//    }
//}

//class SmsCommunicator(
//    private val smsSender : SmsSender = SmsSender()
//){
//    fun communicate(smsCommunicatorData: SmsCommunicatorData){
//        smsSender.send(smsCommunicatorData)
//    }
//}
//class SmsCommunicator(override val communicatorData: SmsCommunicatorData) : Communicator(communicatorData) {
//    override fun communicate(): Either<CommunicateError, CommunicateSuccess> {
//        println("SMS communicator: ${communicatorData.sms}")
//        return CommunicateSuccess().right()
//    }
//}