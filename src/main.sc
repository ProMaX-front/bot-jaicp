require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Добро пожаловать в хату. Представься народу
        
        state: Melon
            q: melon
            a: Знаем такого. Проходи бродяга, падай. По какой статье приняли?
            
            state: left
                q: * *лево*
                a: Не одобряем! Живи оглядывайся, пес.
            
            state: right
                q: * *право*
                a: Так... Ладно, пока располагайся. 
            
            state: forward
                q: * *прямо*
                a: Понятно, свой пацан. Заходи братка.
        
        state: NoMatch
            event!: noMatch
            a: Попробуйте сказать это на пацанском(четком).
            

    state: NoMatch
        event!: noMatch
        a: Попробуйте сказать это на пацанском(четком).

    state: Match
        event!: match
        a: {{$context.intent.answer}}