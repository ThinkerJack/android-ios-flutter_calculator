//
//  ViewController.swift
//  calculator
//
//  Created by orangelab on 2021/7/17.
//

import UIKit

class ViewController: UIViewController {
    let board = Board()
    override func viewDidLoad() {
        super.viewDidLoad()
      self.view.addSubview(board)
        board.snp.makeConstraints{
            (maker) in
            maker.top.equalTo(100)
            maker.height.equalTo(super.view!.snp.height).multipliedBy(0.7)
            maker.width.equalTo(super.view!.snp.width)

    }
    }


}

