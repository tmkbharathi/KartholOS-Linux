import QtQuick
import QtQuick.Controls

ApplicationWindow {
    visible: true
    width: 800
    height: 600
    title: "KartholOS Shell"
    color: "#0a0a12"

    Rectangle {
        anchors.fill: parent
        gradient: Gradient {
            GradientStop { position: 0.0; color: "#0a0a12" }
            GradientStop { position: 1.0; color: "#1a1a2e" }
        }

        Column {
            anchors.centerIn: parent
            spacing: 20

            Text {
                text: "KARTHOL OS"
                font.pixelSize: 64
                font.bold: true
                color: "#e94560"
                style: Text.Outline
                styleColor: "#ffffff"
                anchors.horizontalCenter: parent.horizontalCenter
            }

            Text {
                text: "Premium Linux Experience"
                font.pixelSize: 24
                color: "#95a5a6"
                anchors.horizontalCenter: parent.horizontalCenter
            }

            Rectangle {
                width: 200
                height: 4
                color: "#e94560"
                anchors.horizontalCenter: parent.horizontalCenter
            }

            Row {
                spacing: 40
                anchors.horizontalCenter: parent.horizontalCenter
                
                Button {
                    text: "Terminal"
                    onClicked: console.log("Launching Terminal...")
                }
                
                Button {
                    text: "Browser"
                    onClicked: console.log("Launching Browser...")
                }
                
                Button {
                    text: "Settings"
                    onClicked: console.log("Opening Settings...")
                }
            }
        }

        Text {
            anchors.bottom: parent.bottom
            anchors.right: parent.right
            anchors.margins: 20
            text: "v1.0.0 Alpha | Wayland / Qt6"
            color: "#4a4e69"
            font.pixelSize: 14
        }
    }
}
