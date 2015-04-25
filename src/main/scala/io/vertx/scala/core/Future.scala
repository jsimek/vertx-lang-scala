/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.core;

import scala.util.Try
import io.vertx.core.Handler

class Future[T](private val _asJava: io.vertx.core.Future[T]) {

  def asJava: java.lang.Object = _asJava

  def isComplete(): Boolean = {
    _asJava.isComplete()
  }

  def setHandler(handler: Try[T] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.setHandler(funcToAsyncResultHandler(handler))
  }

  def complete(result: T): Unit = {
    _asJava.complete(result)
  }

  def complete(): Unit = {
    _asJava.complete()
  }

  def fail(failureMessage: String): Unit = {
    _asJava.fail(failureMessage)
  }

}

object Future {

  def apply[T](_asJava: io.vertx.core.Future[T]): io.vertx.scala.core.Future[T] =
    new io.vertx.scala.core.Future[T](_asJava)
  
    def future[T](): io.vertx.scala.core.Future[T] = {
      Future.apply[T](io.vertx.core.Future.future())
    }
  
    def succeededFuture[T](): io.vertx.scala.core.Future[T] = {
      Future.apply[T](io.vertx.core.Future.succeededFuture())
    }
  
    def succeededFuture[T](result: T): io.vertx.scala.core.Future[T] = {
      Future.apply[T](io.vertx.core.Future.succeededFuture(result))
    }
  
    def failedFuture[T](failureMessage: String): io.vertx.scala.core.Future[T] = {
      Future.apply[T](io.vertx.core.Future.failedFuture(failureMessage))
    }
}
