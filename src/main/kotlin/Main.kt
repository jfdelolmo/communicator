import jfo.demo.communicator.CommunicatorChannel
import jfo.demo.communicator.CommunicatorBuilderByChannel
import jfo.demo.communicator.email.EmailInfo
import jfo.demo.communicator.sms.SmsInfo

fun main() {

    val sms = SmsInfo(phone = "(+34)123456789", msg = "This is an sms communication message")
    val email = EmailInfo(address = "test@test.com", content = "This is an email communication content")
    val email2 = EmailInfo("", "")

    val attempts = listOf(
        (CommunicatorChannel.EMAIL to email),
        (CommunicatorChannel.EMAIL to email2),
        (CommunicatorChannel.SMS to sms)
    )

    attempts.forEach { pair ->
        CommunicatorBuilderByChannel()
            .build(pair.first, pair.second)
            .execute()
            .fold(
                { println("Catastrophic fail!! sending ${pair.first} with ${pair.second}") },
                { println("${pair.first} with ${pair.second} sent!") }
            )
    }
}
