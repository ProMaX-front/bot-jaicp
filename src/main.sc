require: slotfilling/slotFilling.sc
  module = sys.zb-common

require: function.js
theme: /

    state: Start
        q!: $regex</start>
        a: Добро пожаловать в хату. Представься народу
        
        state: Melon
            q: * *бродяга*
            a: Знаем такого. Проходи бродяга, падай. По какой статье приняли?
            
            state: left
                q: * *228*
                a: Не одобряем! Живи оглядывайся, пес.
            
            state: right
                q: * *105*
                a: Чтож... Твоя судьба будет определена случайно. Погнали:  $temp.num = {{getRandomInt(5)}} 
                if: $temp.num > 5 
                    a: Ну что, проходи, везунчик. 
                elseif: $temp.num == 5 
                    a: По краю любишь ходить получается, ну ладно. Фарт на твоей стороне сегодня.
                else: $temp.num < 5
                    a: Ну, не повезло. Увидимся в другой жизни.
            
            state: forward
                q: * *169*
                a: Понятно, свой пацан. Заходи братка.
            
            state: back
                q: * (*назад*| *выйти*)
                a: Хахахахах. Отсюда не возвращаются.
        
        state: NoMatch
            event: noMatch
            a: Попробуйте сказать это на пацанском(четком).
            

    state: NoMatch
        event!: noMatch
        a: Попробуйте сказать это на пацанском(четком).

    state: Match
        event!: match
        a: {{$context.intent.answer}}