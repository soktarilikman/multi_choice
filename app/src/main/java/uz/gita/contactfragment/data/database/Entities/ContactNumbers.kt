package uz.gita.contactfragment.data.database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


//
//@Entity(tableName = "contact_numbers")


@Entity(
    tableName = "contact_numbers",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = ContactNames::class,
            parentColumns = ["id"],
            childColumns = ["course_id"],
            onDelete = ForeignKey.CASCADE
        )
    )
)

data class ContactNumbers(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "number")
    val number: String,

    @ColumnInfo(name = "course_id")
    val contactId: Int,

    )