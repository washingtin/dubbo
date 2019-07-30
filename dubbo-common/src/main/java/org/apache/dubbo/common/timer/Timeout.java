/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.apache.dubbo.common.timer;

/**
 *   与Timer返回的TimerTask关联的句柄
 * A handle associated with a {@link TimerTask} that is returned by a
 * {@link Timer}.
 */
public interface Timeout {

    /**
     *  返回创建些handle的Timer
     *
     *  Returns the {@link Timer} that created this handle.
     */
    Timer timer();

    /**
     *  返回与此handle关联的TimerTask
     *
     *  Returns the {@link TimerTask} which is associated with this handle.
     */
    TimerTask task();

    /**
     *  仅当与此handle关联的TimerTask过期才返回true
     *
     *  Returns {@code true} if and only if the {@link TimerTask} associated
     *  with this handle has been expired.
     */
    boolean isExpired();

    /**
     *  仅当与此handle关联的TimerTask取消才返回true
     *
     *  Returns {@code true} if and only if the {@link TimerTask} associated
     *  with this handle has been cancelled.
     */
    boolean isCancelled();

    /**
     *  尝试取消TimerTask
     *  如果已经执行或取消，返回结果无影响
     *
     *  Attempts to cancel the {@link TimerTask} associated with this handle.
     *  If the task has been executed or cancelled already, it will return with
     *  no side effect.
     *
     *      只有成功取消才返回true，其它情况都返回false
     *
     *  @return True if the cancellation completed successfully, otherwise false
     */
    boolean cancel();
}
