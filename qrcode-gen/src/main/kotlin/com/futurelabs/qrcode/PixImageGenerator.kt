package com.futurelabs.qrcode

import java.awt.BorderLayout
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.*

fun createAndShowGUI() {
    val frame = JFrame("Pix generator")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(800, 600)

    // Left Panel with Labels, TextFields and a Button
    val leftPanel = JPanel()
    leftPanel.layout = GridBagLayout()
    val gbc = GridBagConstraints()
    gbc.insets = Insets(5, 5, 5, 5)

    val labels = arrayOf("Pix:", "Nome:", "Cidade:", "Valor:")
    val textFields = Array(4) { JTextField(15) }

    for (i in labels.indices) {
        gbc.gridx = 0
        gbc.gridy = i
        gbc.anchor = GridBagConstraints.EAST
        leftPanel.add(JLabel(labels[i]), gbc)

        gbc.gridx = 1
        gbc.anchor = GridBagConstraints.WEST
        leftPanel.add(textFields[i], gbc)
    }

    val button = JButton("Submit")
    gbc.gridx = 0
    gbc.gridy = labels.size
    gbc.gridwidth = 2
    gbc.anchor = GridBagConstraints.CENTER
    leftPanel.add(button, gbc)

    // Right Panel with an Image
    val rightPanel = JPanel()
    val imageIcon = ImageIcon("./qrcode-gen/qr_codes/qr_code.png") // Replace with your image path
    val imageLabel = JLabel(imageIcon)
    rightPanel.layout = BorderLayout()
    rightPanel.add(imageLabel, BorderLayout.CENTER)

    // Split Pane
    val splitPane = JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel)
    splitPane.dividerLocation = 400

    frame.contentPane.add(splitPane)
    frame.isVisible = true
}

fun main() {
    SwingUtilities.invokeLater {
        createAndShowGUI()
    }
}
