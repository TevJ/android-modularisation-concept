package com.techtev.filmbinder

import com.techtev.coremodule.base.Lse
import com.techtev.coremodule.base.UseCase

interface GetFilmsUseCase: UseCase<Lse<List<Film>>, Unit>