package com.lucifiere.coder2.resolver

import com.lucifiere.coder2.resolver.model.ResolverRequest
import com.lucifiere.coder2.view.View

interface Resolver {

    View resolve(ResolverRequest request)

}
