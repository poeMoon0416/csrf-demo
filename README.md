# csrf-demo
- csrf demo app.
- [参考URL - IPA](https://www.ipa.go.jp/security/vuln/websecurity/csrf.html)

# 構成
- src: 攻撃対象サイト
- trap_site: 罠サイト

# 手順
- 攻撃対象サイトにログインする
- 罠サイトの画像をクリックする
- 攻撃対象サイトにログイン中のユーザーで勝手に投稿されていることを確認する
- 補足: CsrfDemoSecurityConfig.javaのCSRFトークン設定で成否が変わるので注意
