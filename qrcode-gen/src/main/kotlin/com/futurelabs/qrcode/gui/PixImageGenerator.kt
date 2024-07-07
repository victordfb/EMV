package com.futurelabs.qrcode.gui

import java.awt.BorderLayout
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import java.io.File
import javax.imageio.ImageIO
import javax.swing.*

val controller = PixImageGeneratorController()

fun createAndShowGUI() {
    val frame = JFrame("Pix QRCode generator")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(800, 600)
    frame.setLocation(650, 250)

    // Left Panel with Labels, TextFields and a Button
    val leftPanel = JPanel()
    leftPanel.layout = GridBagLayout()
    val gbc = GridBagConstraints()
    gbc.insets = Insets(5, 5, 5, 5)

    val labels = arrayOf("Tipo chave", "Chave Pix:", "Nome:", "Cidade:", "Valor:")
    val textFields = Array(labels.size) { JTextField(15) }

    for (i in labels.indices) {
        gbc.gridx = 0
        gbc.gridy = i
        gbc.anchor = GridBagConstraints.EAST
        leftPanel.add(JLabel(labels[i]), gbc)

        gbc.gridx = 1
        gbc.anchor = GridBagConstraints.WEST
        leftPanel.add(textFields[i], gbc)
    }

    val button = JButton("Gerar QRCode")
    gbc.gridx = 0
    gbc.gridy = labels.size
    gbc.gridwidth = 2
    gbc.anchor = GridBagConstraints.CENTER
    leftPanel.add(button, gbc)
    button.addActionListener {
        val texts = textFields.map { it.getText() }.toTypedArray()
        controller.generateQRCodeImage(texts[0], texts[1], texts[2], texts[3], texts[4])
    }

    // Right Panel with an Image
    val rightPanel = JPanel()
    val imageLabel = JLabel()
    rightPanel.layout = BorderLayout()
    rightPanel.add(imageLabel, BorderLayout.CENTER)
    controller.onQRCodeUpdate { url ->
        val image = ImageIO.read(File(url))
        imageLabel.icon = ImageIcon(image)
    }

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
