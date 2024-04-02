package pruebas.pruebas.pruebas.messaging.Models

import com.google.firebase.Timestamp

data class Message (
    var messageId:String?=null,
    var senderId: String="",
    var text:String="",
    var hasAttachedImage:Boolean=false,
    var messageTimestamp: Timestamp= Timestamp.now(),
)
