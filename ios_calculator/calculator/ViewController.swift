//
//  ViewController.swift
//  calculator
//
//  Created by orangelab on 2021/7/17.
//

import UIKit

class ViewController: UIViewController,BoardButtonInputDelegate {
    let board = Board()
    let screen = Screen()
    override func viewDidLoad() {
        super.viewDidLoad()
        installUI()
    }
    func boardButtonClick(content: String) {
        if(content == "ac"){
            screen.clearContent()
        }
        if(content == "del"){
            screen.deleteInput()
        }
        if content == "="{
            screen.refreshHistory()
        }else{
            screen.inputContent(content: content)
        }
        
    }
    func installUI(){
        self.view.addSubview(board)
        self.view.addSubview(screen)
        board.delegate = self
        board.snp.makeConstraints{
            (maker) in
            maker.height.equalTo(super.view!.snp.height).multipliedBy(2/3.0)
            maker.right.equalTo(0)
            maker.left.equalTo(0)
            maker.bottom.equalTo(0)
        }
        screen.snp.makeConstraints{
            (maker) in
            maker.top.equalTo(20)
            maker.right.equalTo(0)
            maker.left.equalTo(0)
            maker.bottom.equalTo(board.snp.top)
        }
    }


}

