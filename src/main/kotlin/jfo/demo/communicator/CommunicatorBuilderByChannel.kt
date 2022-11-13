package jfo.demo.communicator

import jfo.demo.communicator.email.EmailCommunicator
import jfo.demo.communicator.email.EmailInfo
import jfo.demo.communicator.sms.SmsCommunicator
import jfo.demo.communicator.sms.SmsInfo

class CommunicatorBuilderByChannel {

    fun smsCommunicatorBuilder(data: DataInfo): Communicator = SmsCommunicator(data as SmsInfo)
    fun emailCommunicatorBuilder(data: DataInfo): Communicator = EmailCommunicator(data as EmailInfo)

    fun build(communicationCommunicatorChannel: CommunicatorChannel, data: DataInfo): Communicator {
        return communicationCommunicatorChannel.builderFunction.apply(this, data)
    }
}